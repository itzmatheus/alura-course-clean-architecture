# Alura Course Clean Architecture

## Patterns

#### Entity

- [x] When you class have some kind of "identification" like id or cpf. So you have how diff two or more 
objects based in one or more attributes;

#### Value Object [Article Uncle Bob About It](https://martinfowler.com/bliki/ValueObject.html)

- [x] When your class have not how difference their own objects;
- [x] The interest is about some value;
- [x] Value objects should be immutable;
- [x] If equality between two objects of a class is verified by comparing all their values, it is a Value Object.

## Architecture Conceps

#### Layers

- [x] Our application only depends on our domain, and does not recognize infrastructure details. The infrastructure layer supports the innermost layers.
- [x] Domain layer must be the focus;
- [x] Web, frameworks, persistence mechanism of data are just details.
- [x] The application layer works when we have some logic that do not belong domain layer, but important have in application, so belongs to application layer and the implementations in infrastructure layer;

#### Services

- [x] Domain Service are classes that represents one action between more than one entity;
- [x] Application Services control the flow of some business rules application;
- [x] Infraestructure Services are implementations for present interfaces in domain or application layers;
- [x] Our business rules should stay in the entities and VOs, but that doesn't always make sense. When we need to perform some action that is not part of any entity or a VO, we can use a Service class.