;; Find the sum of all the even fibonacci numbers
;; up to but not including 4000000

 (defn fib [n]
   (if (< n 2)
     1
     (+ (fib (- n 2))
        (fib (- n 1)))))
(fib 1)
(fib 2)
(fib 3)
(for [x (range 20)]
  (fib x))

(fib 30)
(fib 40)
(fib 35)
(fib 33)
(fib 32)

(def fibs (for [x (range 33)]
            (fib x)))
fibs
(def evens (filter even? fibs))
evens
(reduce + evens)

(defn my-fib-sum-v1 [limit]
  (loop [new (range limit)]
    (let [fib-touch (map fib new)
          contains []]
      (reduce +
              (into contains
                    (filter even? fib-touch))))))

(time (my-fib-sum-v1 33))

(defn our-sum-even-fibs [n]
  (loop [i 0
         fibs []]
    (let [fibi (fib i)]
      (if (> fibi n)
        (reduce + (filter even? fibs))
        (recur (inc i) (conj fibs fibi))))))

(time (our-sum-even-fibs 4000000))

;; Memoization 

(def fibss
  (memoize
   (fn [n]
     (if (< n 2)
       1
       (+ (fib (- n 2))
          (fib (- n 1)))))))

(defn my-fib-sum-v2 [limit]
  (loop [new (range limit)]
    (let [fib-touch (map fibss new)
          contains []]
      (reduce +
              (into contains
                    (filter even? fib-touch))))))

(time (my-fib-sum-v2 10))
(time (my-fib-sum-v2 200 ))
(defn our-sum-even-fibss [n]
  (loop [i 0
         fibs []]
    (let [fibi (fibss i)]
      (if (> fibi n)
        (reduce + (filter even? fibs))
        (recur (inc i) (conj fibs fibi))))))
(time (our-sum-even-fibss 44))
(time (our-sum-even-fibss 2000))

