(defn quicksort [l]
  (if (empty? l)
    '()
    (let [[pivot & tail] l]
          (lazy-cat (quicksort (filter (fn [x] (< x pivot)) tail))
                    (list pivot)
                    (quicksort (remove (fn [x] (< x pivot)) tail))))))

(println (quicksort '(5 1 4 2 3)))
