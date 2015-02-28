(ns gilded-rose.core-test
  (:require [clojure.test :refer :all]
            [gilded-rose.core :refer :all]))

(deftest item-tests
  (testing "Creating an item"
    (is (= (item :normal-item 1 3 )
           {:name :normal-item
            :sell-in 1
            :quality 3})))

  (testing "lower sell in quality"
    (is (= (lower-sell-in (item :normal-item 2 3))
           (item :normal-item 1 3)))))

(deftest normal-items
  (testing "Update non-expired items"
    (is (= (update-quality (item :normal-item 2 3))
           (item :normal-item 1 2))))

  (testing "Update expired items"
    (is (= (update-quality (item :normal-item 0 3))
           (item :normal-item -1 1))))

  (testing "Stop quality from going below zero"
    (is (= (update-quality (item :normal-item 1 0))
           (item :normal-item 0 0 )))))
