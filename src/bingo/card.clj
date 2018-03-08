(ns bingo.card
  (:require
    [bingo.card-spec :as card-spec]
    [clojure.test.check.generators :as gen]
    [clojure.spec.alpha :as s]))

(def generator (s/gen ::card-spec/bingo-card))

(defn create []
  (gen/generate generator))

(defn bingo? [card numbers]
  (->> card
       vals
       flatten
       (every? (set numbers))))
