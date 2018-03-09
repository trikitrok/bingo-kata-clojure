(ns bingo.caller)

(def ^:private numbers-bag (atom nil))

(defn call-number! []
  (let [number (rand-nth @numbers-bag)]
    (swap! numbers-bag #(remove #{number} %))
    number))

(defn in-bag? [number]
  ((set @numbers-bag) number))

(defn reset-numbers-bag! []
  (reset! numbers-bag (range 1 76)))
