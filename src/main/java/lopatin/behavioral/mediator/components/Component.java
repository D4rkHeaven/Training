package lopatin.behavioral.mediator.components;

import lopatin.behavioral.mediator.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}

