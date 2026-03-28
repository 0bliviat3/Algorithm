#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	std::string a, b, op;
	std::cin >> a >> op >> b;

	int a_size = a.size() - 1;
	int b_size = b.size() - 1;

    if (op == "*") {
		int size = a_size + b_size;
		std::cout << "1";
		for (int i = 0; i < size; i++) std::cout << "0";
    }
    else if (op == "+") {
		if (a_size == b_size) {
			std::cout << "2";
			for (int i = 0; i < a_size; i++) std::cout << "0";
		}
		else if (a_size > b_size) {
			std::cout << "1";
			for (int i = 0; i < a_size; i++) {
				if (i + b_size == a_size - 1) std::cout << "1";
				else std::cout << "0";
			}
		}
		else {
			std::cout << "1";
			for (int i = 0; i < b_size; i++) {
				if (i + a_size == b_size - 1) std::cout << "1";
				else std::cout << "0";
			}
		}

    }
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}