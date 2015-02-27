(ns gilded-rose.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn item
  "Create an item."
  [name sell-in quality]
  { :name name
    :sell-in sell-in
    :quality quality })
