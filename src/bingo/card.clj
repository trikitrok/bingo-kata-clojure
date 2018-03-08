(ns bingo.card)

(defn create []
  {:b (take 5 (shuffle (range 1 16)))
   :i (take 5 (shuffle (range 16 31)))
   :n (take 4 (shuffle (range 31 46)))
   :g (take 5 (shuffle (range 46 61)))
   :o (take 5 (shuffle (range 61 76)))})
