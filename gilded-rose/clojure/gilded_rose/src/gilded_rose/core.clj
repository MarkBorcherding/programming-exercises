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
