(ns bingo.card-spec
  (:require
    [clojure.spec.alpha :as s]))

(defn create-column-spec [& {:keys [min max n-elements]}]
  (s/coll-of (s/int-in min (inc max)) :kind vector? :count n-elements :distinct true))

(s/def ::b (create-column-spec :min 1 :max 15 :n-elements 5))
(s/def ::i (create-column-spec :min 16 :max 30 :n-elements 5))
(s/def ::n (create-column-spec :min 31 :max 45 :n-elements 4))
(s/def ::g (create-column-spec :min 46 :max 60 :n-elements 5))
(s/def ::o (create-column-spec :min 61 :max 75 :n-elements 5))
(s/def ::bingo-card (s/keys :req-un [::b ::i ::n ::g ::o]))
