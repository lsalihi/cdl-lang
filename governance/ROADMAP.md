# CDL Roadmap

## Vision

CDL aims to become the universal declarative language for expressing business logic and cognitive knowledge across all domains and technologies.

## Current Status: v0.5.0 (MVP)

✅ **Completed**
- Core language syntax (intents, rules, mappings)
- ANTLR4 parser and AST builder
- Basic type checking and symbol table
- OpenAPI 3.0 backend
- Unified CLI (build, gen, lint, fmt)
- Conformance Test Kit (CTK)
- Docker distribution
- Documentation and CI/CD

## v0.6 (Q1 2026) - Type System & IDE Support

### Goals
Transform CDL from a basic DSL into a type-safe, IDE-supported language ready for enterprise adoption.

### Features
- [ ] **Enhanced Type System**
  - Built-in types: `Money(currency)`, `Email`, `GeoPoint`, `DateTime`
  - Type constraints with `where` clauses
  - Custom type definitions
  - Type validation and inference

- [ ] **OpenAPI Backend Enhancement**
  - Real request/response schemas from intent inputs/outputs
  - Proper operationId generation
  - Support for complex types and arrays
  - OpenAPI validation

- [ ] **VS Code Extension (Minimal)**
  - Syntax highlighting
  - Basic diagnostics via CLI
  - Commands: Generate OpenAPI, Lint, Format
  - Marketplace publication

- [ ] **CTK Growth**
  - 10 additional test cases
  - Multi-domain coverage (finance, healthcare, etc.)
  - GitHub Action for CI integration

### Milestones
- **v0.6.0**: Type system basics
- **v0.6.1**: OpenAPI schema generation
- **v0.6.2**: VS Code extension
- **v0.6.3**: CTK expansion

## v0.8 (Q2 2026) - Policy Engine & Enterprise Features

### Goals
Make CDL a complete enterprise-grade language with policy support and advanced tooling.

### Features
- [ ] **Rego Policy Backend**
  - Policy block compilation to OPA Rego
  - Conditional expressions and constraints
  - Integration with policy engines

- [ ] **Advanced Linter**
  - Coverage gap detection
  - Circular flow detection
  - PII/security rule validation
  - Performance analysis

- [ ] **Build Tool Integration**
  - Maven plugin for Java builds
  - Gradle plugin integration
  - Spring Boot integration examples

- [ ] **Distribution Expansion**
  - Homebrew tap for macOS/Linux
  - Enhanced Docker images
  - Windows MSI installer

### Milestones
- **v0.8.0**: Rego backend
- **v0.8.1**: Advanced linting
- **v0.8.2**: Build tool plugins
- **v0.8.3**: Distribution channels

## v1.0 (Q3 2026) - Language Standard

### Goals
Establish CDL as a stable, standardized language with full ecosystem support.

### Features
- [ ] **Language Server Protocol (LSP)**
  - Complete IDE support
  - Advanced diagnostics and autocomplete
  - Refactoring support

- [ ] **Comprehensive CTK**
  - 20+ test cases across domains
  - Automated conformance testing
  - Third-party certification

- [ ] **Ecosystem Growth**
  - Community examples repository
  - Third-party backends
  - Integration libraries

- [ ] **Formal Specification**
  - Complete language grammar
  - Semantic definitions
  - IR specification
  - Compatibility guarantees

### Milestones
- **v1.0.0-rc1**: Feature complete
- **v1.0.0-rc2**: Ecosystem validation
- **v1.0.0**: Stable release

## Long-term Vision (2027+)

### Strategic Goals
- **Universal Adoption**: CDL as the standard for declarative business logic
- **Multi-language Support**: Backends for multiple policy engines, API formats
- **Visual Tools**: Graphical CDL editors and debuggers
- **AI Integration**: ML model specifications and cognitive workflows
- **Industry Standards**: ISO standardization for business logic languages

### Potential Domains
- **Financial Services**: Regulatory compliance, risk modeling
- **Healthcare**: Clinical decision support, data privacy
- **Manufacturing**: Process automation, quality control
- **Government**: Policy automation, regulatory compliance
- **AI/ML**: Model governance, ethical AI frameworks

## Contributing to the Roadmap

The roadmap is community-driven. To propose changes:

1. Open a GitHub Discussion with your idea
2. Create a CEP (CDL Enhancement Proposal) for major features
3. Join roadmap planning sessions (announced on GitHub)

## Release Cadence

- **Patch releases**: As needed for bug fixes
- **Minor releases**: Every 6-8 weeks with new features
- **Major releases**: Annually with breaking changes

## Success Metrics

- **Adoption**: Number of public repositories using CDL
- **Ecosystem**: Third-party tools and integrations
- **Community**: Active contributors and users
- **Standards**: Industry recognition and standards adoption

---

*This roadmap is living document. Priorities may shift based on community feedback and strategic opportunities.*
