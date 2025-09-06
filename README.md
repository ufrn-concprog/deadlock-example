# 🧵 Deadlock Example in Java

[![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Build](https://img.shields.io/badge/build-manual-lightgrey)
[![Docs](https://img.shields.io/badge/docs-Javadoc-green)](./doc/index.html)

An educational repository demonstrating deadlocks in Java multithreading and how to detect them. The learning objectives are:

- Understand what a deadlock is in concurrent programming.  
- See a minimal reproducible example of two threads competing for resources.  
- Learn how to use the [`java.lang.management.ThreadMXBean`](https://docs.oracle.com/en/java/javase/23/docs/api/java.management/java/lang/management/ThreadMXBean.html) interface to detect deadlocks at runtime.  

This project is part of the **Concurrent Programming** module at the [Federal University of Rio Grande do Norte (UFRN)](https://www.ufrn.br), Natal, Brazil.

---

## 📂 Repository Structure

```
.
├── doc/                   # Documentation generated with Javadoc
├── src/                   # Source code
│   ├── Resource.java          # Represents a shared resource locked by threads
│   ├── DeadlockExample.java   # Demonstrates a simple deadlock between two threads
│   └── DeadlockDetection.java # Detects deadlocks using ThreadMXBean
└── README.md
```

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 11+ (works with any modern JDK)
- A terminal or IDE (IntelliJ, Eclipse, VS Code, etc.)

### 🔧 Compilation
Inside the project root, compile all sources:

```bash
javac src/*.java -d out
```

This will place compiled `.class` files inside the `out/` directory.

### ▶️ Running

**Deadlock Example**

Demonstrates a deadlock

```bash
java -cp out DeadlockExample
```

Expected output:

```
Thread T2 is attempting to lock Resource B
Thread T1 is attempting to lock Resource A
Thread T1 locked Resource A
Thread T2 locked Resource B
Thread T1 is attempting to lock Resource B
Thread T2 is attempting to lock Resource A
(deadlock occurs, program hangs)
```

The deadlock occurrence can also be viewed using visual tools like:

- [JConsole](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/tooldescr009.html) is a visual, standalone tool included in the JDK to monitor either local or remote processes
- [VisualVM](https://visualvm.github.io/) is a free, cross-platform visual tool to examine execution over the JVM

**Deadlock Detection** 

Uses the [`ThreadMXBean`](https://docs.oracle.com/en/java/javase/23/docs/api/java.management/java/lang/management/ThreadMXBean.html) interface provided by the [`java.lang.management package`](https://docs.oracle.com/en/java/javase/23/docs/api/java.management/java/lang/management/package-summary.html) to detect the deadlock programmatically:

```bash
java -cp out DeadlockDetection
```

Expected output (simplified):

```
Thread T1 is attempting to lock Resource A
Thread T2 is attempting to lock Resource B
Thread T1 locked Resource A
Thread T2 locked Resource B
Thread T1 is attempting to lock Resource B
Thread T2 is attempting to lock Resource A

Found 2 deadlocked threads
Thread T1 is BLOCKED on object Resource@4c2ad864 owned by Thread T2
Thread T2 is BLOCKED on object Resource@1186ab6c owned by Thread T1
```

In this example, *Thread T1* is created with *Resource A* assigned and wants to hold *Resource B*, while *Thread T2* is created with *Resource B* assigned and wants to hold *Resource A*. This circular wait represents a deadlock.

---

## 📖 Documentation

Javadoc is available in the [`doc/`](doc) directory. Open `doc/index.html` in your browser:

```bash
open doc/index.html    # macOS
xdg-open doc/index.html # Linux
```

---

## 🤝 Contributing

Contributions are welcome! You can:
- Extend with other deadlock scenarios
- Add recovery strategies
- Improve documentation or examples

Fork this repository and submit a pull request 🚀

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
