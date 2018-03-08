(ns bingo.card-test
  (:require
    [clojure.test :refer :all]
    [bingo.card :as card]))

(defn- check-column [& {:keys [column num-elements min max]}]
  (is (= num-elements (count column)))
  (is (apply distinct? column))
  (is (every? #(> (inc max) % (dec min)) column)))

(deftest generating-a-bingo-card
  (let [card (card/create)]
    (testing "column B contains 5 different numbers between 1 and 15 inclusive"
      (check-column :column (:b card) :num-elements 5 :min 1 :max 15))
    (testing "column I contains 5 different numbers between 16 and 30 inclusive"
      (check-column :column (:i card) :num-elements 5 :min 16 :max 30))
    (testing "column N contains 4 different numbers between 31 and 45 inclusive"
      (check-column :column (:n card) :num-elements 4 :min 31 :max 45))
    (testing "column G contains 5 different numbers between 46 and 60 inclusive"
      (check-column :column (:g card) :num-elements 5 :min 46 :max 60))
    (testing "column O contains 5 different numbers between 61 and 75 inclusive"
      (check-column :column (:o card) :num-elements 5 :min 61 :max 75))))
