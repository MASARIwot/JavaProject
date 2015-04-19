(ns com.fibonacci)

(defn fib [x]
  (if (< x 2)
    x
    (+ (fibonacci (- x 1)) (fibonacci (- x 2)) )))


(defn sumEvenNumber [x])


(defn lazy-seq-fibo 
    ([] 
        (concat [0 1] (lazy-seq-fibo 0 1))) 
    ([a b] 
        (let [n (+ a b)] 
            (lazy-seq 
                (cons n (lazy-seq-fibo b n))))))


(defn less-than-four-million? [n] (< n 4000000))


(println (reduce + 
    (filter even? 
        (take-while less-than-four-million? (lazy-seq-fibo)))))