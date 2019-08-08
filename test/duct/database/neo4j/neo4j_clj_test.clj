(ns duct.database.neo4j.neo4j-clj-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [neo4j-clj.core :as neo4j]))

(deftest key-derive-test
  (is (isa? :duct.database.neo4j/neo4j-clj :duct.database/neo4j))
  (is (isa? :duct.database/neo4j :duct/database)))

(deftest init-key-test
  (let [url "bolt://127.0.0.1"
        db (ig/init-key :duct.database.neo4j/neo4j-clj
                        {:url url})]
    (is (= (get-in db [:conn :url]) url))))
