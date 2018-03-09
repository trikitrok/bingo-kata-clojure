(ns bingo.caller-test
  (:require
    [clojure.test :refer :all]
    [bingo.caller :as caller]))

(deftest called-numbers
  (testing "the number is between 1 and 75 inclusive"
    (let [called-numbers (atom #{})]
      (let [number (caller/call-number)]
        (is (>= 75 number 1))
        (swap! called-numbers conj number))
      (let [number (caller/call-number)]
        (is (>= 75 number 1))
        (is (not (@called-numbers number)))
        (swap! called-numbers conj number)))))


