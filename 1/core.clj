(require '[clojure.string :as str])

(def input (slurp "input.txt"))
(def elves (str/split input  #"\n\n"))

(defn get-calories [elf] (map read-string (str/split elf #"\n")))
(defn sum-calories [calories] (reduce + calories))

(def sum (map (comp sum-calories get-calories) elves))
(def top3 (take 3 (sort (comp - compare) (doall sum))))
(print (reduce + top3))