#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

std::vector<std::string> split(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<std::string> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(buffer);
	}

	return result;
}

void solve() {

	std::string str;
	std::getline(std::cin, str);

	int left = 0, right = 0;
	bool flag = false;
	for (char c : str) {
		if (c == '(') {
			flag = true;
		}
		if (c == '@') {
			if (flag) {
				right++;
			}
			else {
				left++;
			}
		}
	}
	std::cout << left << " " << right;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}