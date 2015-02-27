(ns guilded-rose.core)

(defn item [name sell-in quality]
      {:name name
       :sell-in sell-in,
       :quality quality})

(defn lower-sell-in [item] (item (:name item)
                                 (- (:sell-in item) 1)
                                 (:quality item)))


(defmulti update-quality #((:item %)))
(defmethod update-quality :normal-item [x]
  (let [x (lower-sell-in x)]
    (item (:name x)
          (:sell-in x)
          (max 0 (- (:quality x) (if (< 0 (:sell-in x)) 1 2))))))

