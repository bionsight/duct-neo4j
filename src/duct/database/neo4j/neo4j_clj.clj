(ns duct.database.neo4j.neo4j-clj
  (:require [integrant.core :as ig]
            [neo4j-clj.core :as neo4j]))

(derive :duct.database.neo4j/neo4j-clj :duct.database/neo4j)
(derive :duct.database/neo4j :duct/database)

(defrecord Boundary [conn])

(defn- connect-with-options
  "Connect to Neo4j with specific options."
  [{:keys [url user password options]}]
  (if user
    (neo4j/connect url user password options)
    (neo4j/connect url options)))

(defmethod ig/init-key :duct.database.neo4j/neo4j-clj [_ options]
  (let [conn (connect-with-options options)]
    (->Boundary conn)))

(defmethod ig/halt-key! :duct.database.neo4j/neo4j-clj [_ {:keys [conn]}]
  (if-not (nil? conn)
    (neo4j/disconnect conn)))
