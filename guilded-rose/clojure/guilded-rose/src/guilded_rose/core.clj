(ns guilded-rose.core)

(defn update-quality [name sell-in quality]
  (let [sell-in (- sell-in 1)
        quality (max 0 (- quality (if (< 0 sell-in) 1 2)))]
        [name sell-in quality]))

