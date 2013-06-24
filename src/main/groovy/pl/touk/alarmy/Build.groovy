package pl.touk.alarmy; 

import groovy.transform.Canonical
import org.vertx.java.core.json.JsonObject

@Canonical
class Build {

    String project
    Status status
    String displayName

    enum Status {
        SUCCESS, UNSTABLE, FAILED, SUCCESS_BUILDING, UNSTABLE_BUILDING, FAILED_BUILDING, DISABLED
    }

    static Build fromJson(JsonObject buildJson) {    
        new Build(buildJson.toMap())
    }

    public JsonObject toJson() {
        new JsonObject(['project': project, 'status': status, 'displayName': displayName])
    }
}
