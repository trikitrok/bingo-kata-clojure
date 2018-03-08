(ns bingo.card
  (:require
    [bingo.card-spec :as card-spec]
    [clojure.test.check.generators :as gen]
    [clojure.spec.alpha :as s]))

(def generator (s/gen ::card-spec/bingo-card))

(defn create []
  (gen/generate generator))
