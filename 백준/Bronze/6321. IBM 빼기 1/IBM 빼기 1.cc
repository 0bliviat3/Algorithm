#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();

	for (int j = 1; j <= n; j++) {
		std::string str;
		std::getline(std::cin, str);
		for (int i = 0; i < str.size(); i++) {
			if (str[i] == 'Z') {
				str[i] = 'A';
				continue;
			}
			str[i] = str[i] + 1;
		}
		std::cout << "String" << " #" << j << "\n" << str << "\n\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}