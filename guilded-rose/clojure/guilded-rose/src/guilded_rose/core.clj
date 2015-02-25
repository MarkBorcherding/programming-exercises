(ns guilded-rose.core)

(defn update-quality [name sell-in quality]
  (let [sell-in (- sell-in 1)
        quality (- quality 1)]
        [name sell-in quality]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

