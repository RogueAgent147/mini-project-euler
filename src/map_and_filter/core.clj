(ns map-and-filter.core
  (:gen-class))

(map count ["Let's" "measure" "word" "length" "now"])
(map (fn [e] (str e ": " (count e))) ["Let's" "measure" "word" "length" "now"])
(filter keyword? ["a" :a "c" :d "e" :f "g"])
(filter odd? [1 2 3 4 5])
(remove odd? [1 2 3 4 5])
(filter (constantly true) [1 2 3 4 5])
(filter (constantly false) [1 2 3 4 5])

(take 3 [1 2 3 4 5])
(take-while #(> 10 %) [2 9 4 12 3 99 1])
(drop 3 [1 2 3 4 5])
(drop-while #(> 10 %) [2 9 4 12 3 99 1])


(def student  [{:name "Eliza"  :year 1994}
               {:name "Salma" :year 1995}
               {:name "Jodie" :year 1997}
               {:name "Kaitlyn" :year 2000}
               {:name "Alice" :year 2001}
               {:name "Pippa" :year 2002}
               {:name "Fleur" :year 2002}])

(def less-2000 #(< (:year %) 2000))
(take-while less-2000 student)
(drop-while less-2000 student)

(map (fn [x] (* x 10))
     (filter odd? [1 2 3 4 5]))

(->> [1 2 3 4 5 6]
     (filter odd?)
     (map (fn [x] (* x 10))))

(defn our-range [limit]
  (take-while #(< % limit) (iterate inc 0)))

(range)


(->>  (range)
      (map #(* 10 %)) 
      (take 5))

