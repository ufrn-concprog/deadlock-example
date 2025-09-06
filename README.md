# 🧵 Deadlock Example in Java

[![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Build](https://img.shields.io/badge/build-manual-lightgrey)
[![Docs](https://img.shields.io/badge/docs-Javadoc-green)](./doc/index.html)

An educational repository demonstrating **deadlocks** in Java multithreading, and how to **detect** them using the `ThreadMXBean` API.  

This project is part of the **Concurrent Programming** course at [UFRN](https://www.ufrn.br).

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
- **Java 11+** (works with any modern JDK)
- A terminal or IDE (IntelliJ, Eclipse, VS Code, etc.)

### 🔧 Compilation
Inside the project root, compile all sources:

```bash
javac src/*.java -d out
```

This will place compiled `.class` files inside the `out/` directory.

### ▶️ Running

**Deadlock Example** (demonstrates a deadlock):

```bash
java -cp out DeadlockExample
```

Expected output:

```
Thread-1: Locked Resource A
Thread-2: Locked Resource B
Thread-1: Waiting for Resource B...
Thread-2: Waiting for Resource A...
(deadlock occurs, program hangs)
```

**Deadlock Detection** (uses `ThreadMXBean` to detect the deadlock):

```bash
java -cp out DeadlockDetection
```

Expected output (simplified):

```
Thread-1: Locked Resource A
Thread-2: Locked Resource B
Deadlock detected!
Thread-1 is waiting for Thread-2
Thread-2 is waiting for Thread-1
```

---

## 📖 Documentation

Javadoc is available in the [`doc/`](doc) directory. Open `doc/index.html` in your browser:

```bash
open doc/index.html    # macOS
xdg-open doc/index.html # Linux
```

---

## 🧠 Learning Objectives

- Understand **what a deadlock is** in concurrent programming.  
- See a **minimal reproducible example** of two threads competing for resources.  
- Learn how to use the `java.lang.management.ThreadMXBean` API to **detect deadlocks** at runtime.  

---

## 🤝 Contributing

Contributions are welcome!  
You can:
- Extend with other deadlock scenarios
- Add recovery strategies
- Improve documentation or examples

Fork this repo and submit a pull request 🚀

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙏 Acknowledgments

Developed for educational purposes in the **Concurrent Programming** course at UFRN.  
Thanks to the students and professors who contributed to the examples.
