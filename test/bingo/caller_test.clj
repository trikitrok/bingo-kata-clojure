(ns bingo.caller-test
  (:require
    [clojure.test :refer :all]
    [bingo.caller :as caller]))

(deftest called-numbers
  (testing "the number is between 1 and 75 inclusive"
    (is (>= 75 (caller/call-number) 1))))


