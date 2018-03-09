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
    (check (caller/call-number!))))


