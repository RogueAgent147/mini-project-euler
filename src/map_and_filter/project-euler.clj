;; find the sum of all the multiples of 
;; 3 and 5 less than a 1000

(range 3 1000 3)
(reduce + (range 3 1000 3))
(range 5 1000 5)
(reduce + (range 5 1000 5))
(def m3 (reduce + (range 3 1000 3)))
(def m5 (reduce + (range 5 1000 5)))
(def m15 (reduce + (range 15 1000 15)))
(- (+ m3 m5) m15)

(def l (reduce +
               (set (concat (range 5 1000 5) (range 3 1000 3)))))

(defn our-sum-multiple [mult1 mult2 limit]
  (let [h1 (range mult1 limit mult1)
        h2 (range mult2 limit mult2)]
    (reduce + (set (concat h1 h2)))))

(our-sum-multiple 3 5 1000)
(our-sum-multiple 2 6 1000)


(defn our-sum-multiple-r
([limit mult]
 (reduce + (range mult limit mult)))
([limit mult1 mult2]
 (let [h1 (range mult1 limit mult1)
       h2 (range mult2 limit mult2)]
   (reduce + (set (concat h1 h2))))))

;; just playing around though this does not work 

(defn our-sum-multiple-r
  ([limit mult] 
   (reduce + (range mult limit mult)))
  ([limit mult1 mult2] 
   (let [h1 (range mult1 limit mult1)
         h2 (range mult2 limit mult2)]
     (reduce + (set (concat h1 h2)))))
  ([limit mult1 & tail] 
   (loop [h2r tail
          new-mesh []] 
     (if (empty? tail) 
       (our-sum-multiple-r limit mult1) 
       (let [h1r mult1]
         (recur tail
                (reduce + 
                        (into new-mesh
                              (set (our-sum-multiple-r limit h1r))))))))))


 (defn our-summ
   [multiples limit]
   (->> multiples
    (mapcat #(range % limit %))
    set
    (reduce +)))
 
 (our-summ [2 3 6] 1000)

 (time (our-summ [2 3 4 5] 10000000))

 (reduce + (range 1 100 1))
 (reduce + (range 2 100 2))

 (defn sum-up-to [n] 
   (/ (+ n (* n n))2))
 (sum-up-to 100)

 

  