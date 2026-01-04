# Core Java Design Pattern Assignments

## Assignment 1

ASSIGNMENT 1: Configuration Management System (Singleton & Factory)
--------------------------------------------------------------------------------
SCENARIO:
You are building a configuration management system for a microservices application.

REQUIREMENTS:
1. SINGLETON PATTERN - Implement a ConfigurationManager class that:
   - Uses thread-safe Singleton pattern (Double-Checked Locking)
   - Stores configuration as key-value pairs in a HashMap
   - Provides getConfig(String key) and setConfig(String key, String value) methods
   - Has a method loadFromSource(ConfigSource source) to load configurations

2. FACTORY PATTERN - Implement a ConfigSourceFactory that:
   - Creates different types of configuration sources:
     * JsonConfigSource
     * YamlConfigSource
     * PropertiesConfigSource
   - Each source should implement a ConfigSource interface with a readConfig() method
   - Factory should have a createSource(String type, String filePath) method

DELIVERABLES:
- ConfigurationManager class (Singleton)
- ConfigSource interface
- Three concrete implementations (Json, Yaml, Properties)
- ConfigSourceFactory class
- Demo showing thread safety and loading from different sources

BONUS CHALLENGES:
- Add a refreshConfig() method that reloads configuration from the source
- Implement a caching mechanism in the factory to reuse ConfigSource instances

TIP: Start with the interfaces, then implement concrete classes, and finally test 
with a main class.

---

## Assignment 2

================================================================================
ASSIGNMENT 2: Smart Home Automation System (Command, Observer & Builder)
Time: 45 minutes
================================================================================
SCENARIO:
You are building a smart home automation system that controls various devices 
and notifies users of events.

PART 1 - COMMAND PATTERN: Implement device controls
- Create a SmartDevice interface with methods:
  * turnOn()
  * turnOff()
  * getStatus()

- Implement concrete devices:
  * SmartLight
  * SmartThermostat
  * SmartDoorLock

- Create Command interface and concrete commands:
  * TurnOnCommand
  * TurnOffCommand
  * SetTemperatureCommand

- Implement a RemoteControl class (Invoker) that executes commands
- BONUS: Add undo functionality to reverse the last command

PART 2 - OBSERVER PATTERN: Implement event notifications
- Create a DeviceEventPublisher (Subject) that tracks device state changes
- Implement observers:
  * MobileAppNotifier
  * EmailNotifier
  * LoggingService

- When any device state changes, all registered observers should be notified
- Each observer should display the notification in its own way

PART 3 - BUILDER PATTERN: Implement automation rule creation
- Create an AutomationRule class with:
  * ruleName
  * triggerDevice
  * triggerCondition
  * actionCommand
  * schedule
  * enabled

- Implement an AutomationRule.Builder for constructing complex rules
- Support method chaining

DELIVERABLES:
- All device classes implementing SmartDevice interface
- Command pattern implementation with at least 3 commands
- Observer pattern with DeviceEventPublisher and 3 observers
- AutomationRule class with Builder
- A demo class showing:
  * Creating devices and executing commands
  * Registering observers and triggering notifications
  * Building complex automation rules using the Builder
  * Executing an automation rule that triggers commands and notifies observers

---

## Assignment 3

================================================================================
ASSIGNMENT 3: Document Processing System (Prototype, Decorator & Facade)
================================================================================
SCENARIO:
You are building an enterprise document processing system that handles various 
document types and applies formatting.

PART 1 - PROTOTYPE PATTERN: Implement document templates
- Create an abstract Document class implementing Cloneable
- Implement concrete types:
  * Invoice
  * Contract
  * Report

- Each document should have:
  * title
  * content
  * metadata (Map<String, String>)

- Implement clone() method for creating copies
- Create a DocumentRegistry that stores template documents and returns clones

PART 2 - DECORATOR PATTERN: Implement document processing pipeline
- Create a DocumentProcessor interface with process(Document doc) method
- Base implementation: BasicDocumentProcessor

- Decorators to add:
  * WatermarkDecorator - adds watermark to document
  * EncryptionDecorator - encrypts document content
  * CompressionDecorator - compresses document
  * AuditLogDecorator - logs processing activity

- Allow chaining multiple decorators

PART 3 - FACADE PATTERN: Simplify document operations
- Create a DocumentServiceFacade that hides complexity of:
  * Creating documents from templates
  * Processing through multiple decorators
  * Validating documents
  * Saving to storage

- Provide simple methods like:
  * createInvoice()
  * createSecureContract()
  * generateReport()

DELIVERABLES:
- Document class hierarchy with Prototype pattern
- DocumentRegistry for managing templates
- DocumentProcessor interface and 4 decorators
- DocumentServiceFacade
- A comprehensive demo showing:
  * Creating documents from templates
  * Cloning and modifying documents
  * Processing documents through decorator chain
  * Using facade for simplified operations

BONUS CHALLENGES:
- Add validation in the Facade before processing
- Implement a decorator that can be removed (like undo functionality)
- Add different types of documents to the registry
