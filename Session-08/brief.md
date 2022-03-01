# In brief...

## Template Method:

Allows several classes to follow the same process, but implement the steps differently.

## Chain of Responsibility:

Flexible way to join operations into a sequence, where each operation handles requests, or passes them down the chain.

## Mediator:

Decouple several interacting objects by introducing a mediator object, so they don't talk to each other, but only to the mediator.

## Observer:

Decouple an object's events from the other objects it affects, by making then into observers and notifying them whenever there is a change.

## Command:

When an object calls a method on another object, we can gain flexibility by turning the request into an object. It makes it possible for the requests to be inspected, queued, or put into a history for undo/redo operations.

## State:

When an object's behaviour needs to change according to its state, and the actions it performs. (See "finite-state machines".)

## Model-View-Controller:

Separate a UI (view) from the underlying data (model), and the validation and execution of UI activity (controller).