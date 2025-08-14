#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

std::vector<char> split_to_char(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<char> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(buffer[0]);
	}

	return result;
}

void solve() {

	std::string input;
	std::string line;
	std::getline(std::cin, input);
	std::getline(std::cin, line);
	std::vector<char> b = split_to_char(line, ' ');

	std::string ans;

	for (char c : input) {
		bool flag = false;
		for (char c2 : b) {
			if (c == c2) {
				ans += (c - 'A' + 'a');
				flag = true;
				break;
			}
		}
		if (flag) continue;
		ans += c;
	}

	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}