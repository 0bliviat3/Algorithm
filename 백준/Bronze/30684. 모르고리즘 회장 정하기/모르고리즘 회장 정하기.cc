#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n;

	std::cin >> n;

	std::cin.ignore();

	std::string line;
	std::vector<std::string> arr;
	while (n--) {
		std::getline(std::cin, line);
		if (line.size() == 3) {
			arr.push_back(line);
		}
	}

	std::sort(arr.begin(), arr.end());
	std::cout << arr[0];

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}