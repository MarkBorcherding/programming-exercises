(ns guilded-rose.core-test
  (:require [clojure.test :refer :all]
            [guilded-rose.core :refer :all]))

(deftest a-test
  (testing "update quality"

    (testing "normal items"
      (is (= (update-quality :normal-item 2 3)
             [:normal-item 1 2])
          "Items degrade daily")

      (is (= (update-quality :normal-item 0 3)
             [:normal-item -1 1])
          "Expired items degrade twice as fast")

      (is (= (update-quality :normal-item 0 0)
             [:normal-item -1 0])
          "Quality can never be negative")

      )))

