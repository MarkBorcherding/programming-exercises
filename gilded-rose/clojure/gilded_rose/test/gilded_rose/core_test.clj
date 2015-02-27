(ns gilded-rose.core-test
  (:require [clojure.test :refer :all]
            [gilded-rose.core :refer :all]))

(deftest item-tests
  (testing "Creating an item"
    (is (= (item :normal 1 3 )
           {:name :normal
            :sell-in 1
            :quality 3})))

  (testing "lower sell in quality"
    (is (= (lower-sell-in (item :normal 2 3))
           (item :normal 1 3)))))

