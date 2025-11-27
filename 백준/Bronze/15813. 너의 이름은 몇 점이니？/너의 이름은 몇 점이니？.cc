#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::string name;

	std::cin >> n;

	std::cin.ignore();
	std::getline(std::cin, name);

	int sum = 0;
	for (char c : name) {
		sum += (c - 'A' + 1);
	}

	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}