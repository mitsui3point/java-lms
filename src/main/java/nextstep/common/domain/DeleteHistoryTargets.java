package nextstep.common.domain;

import java.util.ArrayList;
import java.util.List;

public class DeleteHistoryTargets {

    private final List<DeleteHistory> targets;

    public DeleteHistoryTargets() {
        this.targets = new ArrayList<>();
    }

    public DeleteHistoryTargets(List<DeleteHistory> targets) {
        this.targets = targets;
    }

    public List<DeleteHistory> asList() {
        return List.copyOf(targets);
    }

    public void addFirst(DeleteHistory deleteHistory) {
        this.targets.add(0, deleteHistory);
    }

    public void add(DeleteHistoryTargets deleteHistoryTargets) {
        this.targets.addAll(deleteHistoryTargets.asList());
    }
}