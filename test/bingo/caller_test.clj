(ns bingo.caller-test
  (:require
    [clojure.test :refer :all]
    [bingo.caller :as caller]))

(defn- check [number]
  (is (>= 75 number 1))
  (is (not (caller/in-bag? number))))

(deftest called-numbers
  (testing "the numbers are between 1 and 75 inclusive and are different each time"
    (caller/reset-numbers-bag!)
    (check (caller/call-number!))
    (check (caller/call-number!)))
  (testing "after calling number 75 times, all numbers between 1 and 75 are present"
    (caller/reset-numbers-bag!)
    (let [called-numbers (atom #{})]
      (dotimes [_ 75]
        (swap! called-numbers conj (caller/call-number!)))
      (is (= @called-numbers (set (range 1 76)))))))

