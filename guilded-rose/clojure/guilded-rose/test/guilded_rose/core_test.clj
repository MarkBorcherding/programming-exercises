(ns guilded-rose.core-test
  (:require [clojure.test :refer :all]
            [guilded-rose.core :refer :all]))

(deftest a-test
  (testing "updating a quality on a normal item"
    (is (= ( update-quality :normal-item 2 3 )
           [:normal-item 1 2]))))

