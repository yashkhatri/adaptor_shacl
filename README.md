# SHACL Sample Adaptor

This is an experiment with [shaclex](https://github.com/labra/shaclex) library in an OSLC adaptor.

## Setup

Run Jetty using `mvn clean jetty:run-exploded`.

Navigate to the [OSLC Service Provider Catalog](http://localhost:8080/SampleAdaptor/services/catalog/singleton).

Expected output **in the console**:

    y.b.name.SampleAdaptorManager - Result Solution
    :y +:S OK. Evidences: Checked maxCount(2) for predicate(<http://example.org/p>) on node <http://example.org/y>
     Checked minCount(1) for predicate(<http://example.org/p>) on node <http://example.org/y>
    :x +:S OK. Evidences: Checked maxCount(2) for predicate(<http://example.org/p>) on node <http://example.org/x>
     Checked minCount(1) for predicate(<http://example.org/p>) on node <http://example.org/x>
