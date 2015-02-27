(ns gilded-rose.core)

(defn item
  "Create an item."
  [name sell-in quality]
  {:name name
   :sell-in sell-in
   :quality quality})

(defn lower-sell-in
  "Lower the sell in count nightly."
  [itm]
  (item (:name itm)
        (- (:sell-in itm) 1)
        (:quality itm)))

(defn update-quality
  "Update the quality of an item"
  [itm]
  (let [itm (lower-sell-in itm)]
    (item (:name itm)
          (:sell-in itm)
          (- (:quality itm)
             (if (< 0 (:sell-in itm))
               1
               2)))))



