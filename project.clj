(defproject bionsight/duct-neo4j "0.0.2"
  :description "Integrant methods for connecting to Neo4j via neo4j-clj"
  :url "https://github.com/bionsight/duct-neo4j"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :lein-release {:scm :git :deploy-via :clojars}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [integrant "0.6.3"]
                 [gorillalabs/neo4j-clj "2.0.1"]])
