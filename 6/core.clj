;; reduce f a = f (a[1]) (reduce f (a[1:]))
;; where f: <a b> => a

(def detect-len 14)
(defn all-different [chrs] (
                            if (= (count chrs) 2)
                            (not= (first chrs) (last chrs))
                            (and 
                             (all-different (drop 1 chrs))
                             (every? #(not= (first chrs) %) (drop 1 chrs)))))

(def input (slurp "input.txt"))
(def s (seq input))

(def result (reduce (fn [vec e]
                      (if (all-different (first vec))
                        (reduced vec)
                        [(concat (drop 1 (first vec)) [e]) (+ (last vec) 1)]))
                    (vector (take detect-len s) detect-len)
                    (drop detect-len s)))

(print result)