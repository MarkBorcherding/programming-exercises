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
        (dec (:sell-in itm))
        (:quality itm)))

(defmulti update-quality (fn [x] (:name x)))

(defmethod update-quality :normal-item
  [itm]
  (let [itm (lower-sell-in itm)]
    (item (:name itm)
          (:sell-in itm)
          (- (:quality itm)
             (if (pos? (:sell-in itm)) 1 2)))))
