(ns bingo.checking-bingo-test
  (:require
    [clojure.test :refer :all]
    [bingo.card :as card]))

(deftest checking-card-has-bingo
  (let [a-card {:b [12 13 11 8 15],
                :i [27 23 25 30 28],
                :n [38 44 43 33],
                :g [48 56 54 57 49],
                :o [70 63 68 62 73]}]
    (is (card/bingo? a-card
                     [12 13 11 8 15 27 23 25 30 28 38 44 43 33 48 56 54 57 49 70 63 68 62 73]))
    (is (not (card/bingo? a-card
                          [12 13 11 8 15 27 23 25 30 28 38 44 43 33 48 56 54 57 49 70])))
    (is (not (card/bingo? a-card [])))))
