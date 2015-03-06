(ns gilded-rose.core)

(defn item
  "Create an item."
  [name sell-in quality]
  {:name name
   :sell-in sell-in
   :quality (max (min quality 50) 0)})

(defn lower-sell-in
  "Lower the sell in count nightly."
  [itm]
  (item (:name itm)
        (dec (:sell-in itm))
        (:quality itm)))

(defmulti update-quality (fn [x] (:name x)))

(defmethod update-quality :sulfuras [itm] itm)

(defmethod update-quality :backstage-pass [itm]
  (let [itm (lower-sell-in itm)
        q (:quality itm)]
    (item (:name itm)
          (:sell-in itm)
           (cond
             (< 10 (:sell-in itm)) (+ 1 q)
             (< 3 (:sell-in itm)) (+ 2 q)
             (< 0 (:sell-in itm)) (+ 3 q)
             :else 0))))

(defmethod update-quality :default
  [itm]
  (let [itm (lower-sell-in itm)]
    (item (:name itm)
          (:sell-in itm)
          (- (:quality itm)
             (if (pos? (:sell-in itm)) 1 2)))))

(defmethod update-quality :aged-brie
  [itm]
  (let [itm (lower-sell-in itm)]
    (item (:name itm)
          (:sell-in itm)
          (+ (:quality itm)
             (if (pos? (:sell-in itm)) 1 2)))))
