(defn factorial [n]
  (if (= n 0)
    1
    (* n (factorial (- n 1)))))

(println (factorial 2))
(println (factorial 3))
(println (factorial 4))
