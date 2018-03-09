(ns bingo.caller)

(def ^:private numbers-bag (atom (range 1 76)))

(defn call-number []
  (let [number (rand-nth @numbers-bag)]
    (swap! numbers-bag #(remove #{number} %))
    number))
