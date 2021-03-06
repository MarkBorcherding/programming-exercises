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

(deftest sulfuras
  (testing "Sulfuras never reduces the sell in date"
    (is (= (update-quality (item :sulfuras 1 1))
           (item :sulfuras 1 1)))))

(deftest backstage-pass
  (testing "quality increases by 1 more than 10 days out"
    (is (= (update-quality (item :backstage-pass 13 1))
           (item :backstage-pass 12 2))))

  (testing "quality increases by two when more than 3 days out"
    (is (= (update-quality (item :backstage-pass 6 1))
           (item :backstage-pass 5 3)))))

(deftest aged-brie
  (testing "Quality goes up as it gets older"
    (is (= (update-quality (item :aged-brie 2 3))
           (item :aged-brie 1 4))))

  (testing "Quality goes up twice as fast after sell in"
    (is (= (update-quality (item :aged-brie 0 3))
           (item :aged-brie -1 5))))

  (testing "Quality cannot go above 50"
    (is (= (update-quality (item :aged-brie 2 50))
           (item :aged-brie 1 50)))))
