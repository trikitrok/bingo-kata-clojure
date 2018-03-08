(ns bingo.card-creation-test
  (:require
    [clojure.test :refer :all]
    [bingo.card :as card]
    [clojure.test.check.clojure-test :refer [defspec]]
    [clojure.test.check.properties :as prop]))

(defn- check-column [& {:keys [column num-elements min max]}]
  (is (= num-elements (count column)))
  (is (apply distinct? column))
  (is (every? #(> (inc max) % (dec min)) column)))

(def valid-bingo-card
  (prop/for-all [card card/generator]
    (check-column :column (:b card) :num-elements 5 :min 1 :max 15)
    (check-column :column (:i card) :num-elements 5 :min 16 :max 30)
    (check-column :column (:n card) :num-elements 4 :min 31 :max 45)
    (check-column :column (:g card) :num-elements 5 :min 46 :max 60)
    (check-column :column (:o card) :num-elements 5 :min 61 :max 75)))

(defspec generated-bingo-cards-are-valid
  200
  valid-bingo-card)
