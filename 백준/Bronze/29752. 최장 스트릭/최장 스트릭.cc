#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

std::vector<int> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<int> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(std::stoi(buffer));
	}

	return result;
}

void solve() {

	int n;
	std::string line;
	std::cin >> n;
	std::cin.ignore();

	std::getline(std::cin, line);
	std::vector<int> a = split_to_int(line, ' ');
	a.push_back(0);

	int cnt = 0;
	int max = 0;
	for (int num : a) {
		if (num > 0) {
			cnt++;
		} else {
			if (cnt > max) {
				max = cnt;
			}
			cnt = 0;
		}
	}

	std::cout << max;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}